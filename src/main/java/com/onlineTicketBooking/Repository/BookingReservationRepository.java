package com.onlineTicketBooking.Repository;


import com.onlineTicketBooking.Constants.QueryConstants;
import com.onlineTicketBooking.CoustamizeException.DBException;
import com.onlineTicketBooking.DTO.BookingDTO;
import com.onlineTicketBooking.Util.ConnectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository
public class BookingReservationRepository {
    @Autowired
    private ConnectionUtil util;

    private Connection connection;
    private PreparedStatement pstmt;

    //ticket_NO,show_Name,time, date,seat_NO,seat_class;
    public int InsertReserveSeat(BookingDTO bookingDTO)throws DBException{
        try {
            System.out.println("onlineTicketBooking.Repository Success");
            connection = util.getConnection();
            pstmt = connection.prepareStatement(QueryConstants.Online_Ticket_Insert_Query);
            pstmt.setInt(1, lastTicketNO()+1);
            pstmt.setString(2, bookingDTO.getShow_Name());
            pstmt.setString(3, bookingDTO.getTime());
            pstmt.setString(4, bookingDTO.getDate());
            pstmt.setString(5, bookingDTO.getSeat_NO());
            pstmt.setString(6, bookingDTO.getSeat_class());

            pstmt.executeQuery();
        }catch (Exception e){
            System.out.println(e);
            throw new DBException("Exception while inserting in onlineTicketBooking.Repository",e);
        }finally {
            try{
            connection.close();
            pstmt.close();
            }catch (Exception e){

            }
        }
        return 0;
    }
    public int lastTicketNO()throws Exception{
        try {
            connection = util.getConnection();
           pstmt=connection.prepareStatement("SELECT ticket_NO FROM Ticket ORDER BY ticket_NO DESC LIMIT 1");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                return rs.getInt(" ticket_NO");
            }
        }catch (DBException e){
            throw new DBException("Exception while adding lastTicketNO");
        }finally {
            connection.close();
        }
        return 0;
    }
//show_Name,time,date,seat_NO,seat_class From Ticket where ticket_NO=?
    public BookingDTO GetReserveSeatByTicketNo(String ticket_NO)throws DBException{
        try{
            connection= util.getConnection();
            pstmt=connection.prepareStatement(QueryConstants.Online_Ticket_Get_Query);
            pstmt.setString(1,ticket_NO);

            ResultSet rs= pstmt.executeQuery();

            while (rs.next()){
                System.out.println("GetReserveSeatByTicketNo Repo Success ");
                BookingDTO bookingDTO=new BookingDTO();
                bookingDTO.setShow_Name(rs.getString("Show Name"));
                bookingDTO.setTime(rs.getString("Time"));
                bookingDTO.setDate(rs.getString("Date"));
                bookingDTO.setSeat_NO(rs.getString("Seat No"));
                bookingDTO.setSeat_class(rs.getString("Seat Class"));
                bookingDTO.setTicket_NO(rs.getString("Ticket No"));

                return bookingDTO;
            }

        }catch (Exception e){
                   throw new DBException("Exception while GetReserveSeatByTicketNo",e);
        }finally {
            try{
            connection.close();
            pstmt.close();
            }catch (Exception e){

            }

        }
        return null;
    }
    public BookingDTO DeleteReserveSeatByTicketNo(String ticket_NO)throws Exception{
        try {
            System.out.println("DeleteReserveSeatByTicketNo Repo Success");
            connection= util.getConnection();
            pstmt=connection.prepareStatement(QueryConstants.Online_Ticket_Delete_Query);
            pstmt.setString(1,ticket_NO);

            pstmt.executeQuery();

        }catch (Exception e){
                   throw new DBException("Exception While DeleteReserveSeatByTicketNo",e);
        }finally {
            connection.close();
            pstmt.close();
        }
        return null;
    }
    //set time=?,date=?,seat_NO=?,seat_class=? where ticket_NO=?
    public void UpdateReserveSeatByTicketNo(BookingDTO bookingDTO)throws Exception{
        try {
            System.out.println("UpdateReserveSeatByTicketNo Repo Success");
            connection= util.getConnection();
            pstmt=connection.prepareStatement(QueryConstants.Online_Ticket_Update_Query);
            pstmt.setString(1,bookingDTO.getTime());
            pstmt.setString(2,bookingDTO.getDate());
            pstmt.setString(3,bookingDTO.getSeat_NO());
            pstmt.setString(4,bookingDTO.getSeat_class());
            pstmt.setString(5,bookingDTO.getTicket_NO());

        }catch (Exception e){
            throw new DBException("Exception while UpdateReserveSeatByTicketNo",e);
        }finally {
            try {
                connection.close();
                pstmt.close();
            }catch (Exception e){

            }
        }
    }
    public void ViewReserveSeatTicket(BookingDTO bookingDTO)throws Exception{
       try {
           System.out.println("ViewReserveSeatTicket Repo Success");
           connection= util.getConnection();
           pstmt=connection.prepareStatement(QueryConstants.Online_Ticket_View_Query);
           pstmt.setString(1, bookingDTO.getTicket_NO());
           pstmt.setString(2, bookingDTO.getShow_Name());
           pstmt.setString(3, bookingDTO.getTime());
           pstmt.setString(4, bookingDTO.getDate());
           pstmt.setString(5, bookingDTO.getSeat_NO());
           pstmt.setString(6, bookingDTO.getSeat_class());

           pstmt.executeQuery();

       }catch (Exception e){
           throw new DBException("Exception while ViewReserveSeatTicket",e);
       }finally {
           connection.close();
           pstmt.close();
       }
    }
}

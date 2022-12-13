package com.onlineTicketBooking.Service;

import com.onlineTicketBooking.CoustamizeException.DBException;
import com.onlineTicketBooking.DTO.BookingDTO;
import com.onlineTicketBooking.Repository.BookingReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingReservationService {
    @Autowired
    BookingReservationRepository repository;

    public String InsertReserveSeat(BookingDTO bookingDTO)throws Exception{
        try{
            System.out.println("InsertReserveSeat Service Success");
            int ticket_NO=repository.InsertReserveSeat(bookingDTO);
            return "CMH"+ticket_NO;
        }catch (Exception e){
            throw new DBException("Exception in InsertReserveSeat Service",e);
        }
    }

    public BookingDTO GetReserveSeatByTicketNo(String ticket_NO)throws Exception{
        try {
            System.out.println("GetReserveSeatByTicketNo Service Success");
            return repository.GetReserveSeatByTicketNo(ticket_NO);
        }catch (Exception e){
                throw new DBException("Exception in GetReserveSeatByTicketNo Service",e);
        }
    }

    public void DeleteReserveSeatByTicketNo(String ticket_NO)throws Exception{
        try {
            System.out.println("DeleteReserveSeatByTicketNo Service Success");
            repository.DeleteReserveSeatByTicketNo(ticket_NO);
        }catch (Exception e){
                throw new DBException("Exception in DeleteReserveSeatByTicketNo",e);
        }
    }

    public void UpdateReserveSeatByTicketNo(BookingDTO bookingDTO)throws Exception{
        try {
            System.out.println("UpdateReserveSeatByTicketNo Service Success");
            repository.UpdateReserveSeatByTicketNo(bookingDTO);
        }catch (Exception e){
            throw new DBException("Exception in UpdateReserveSeatByTicketNo Service");
        }
    }

    public void ViewReserveSeatTicket(BookingDTO bookingDTO)throws Exception{
        try {
            System.out.println("ViewReserveSeatTicket Service Success");
            repository.ViewReserveSeatTicket(bookingDTO);
        }catch (Exception e){
            throw new DBException("Exception in ViewReserveSeatTicket Service");
        }
    }
}

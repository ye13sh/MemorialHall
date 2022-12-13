package com.onlineTicketBooking.Constants;

public class QueryConstants {
    //ticket_NO,show_Name,time, date,seat_NO,seat_class;

    public static final String Online_Ticket_Insert_Query="insert into Ticket(ticket_NO,show_Name,time,date,seat_NO,seat_class) VALUE(?,?,?,?,?,?)";
    public static final String Online_Ticket_Delete_Query="delete From Ticket where ticket_NO=?";
    public static final String Online_Ticket_Get_Query="select show_Name,time,date,seat_NO,seat_class From Ticket where ticket_NO=?";
    public static final String Online_Ticket_Update_Query="update Ticket set time=?,date=?,seat_NO=?,seat_class=? where ticket_NO=?";
    public static final String Online_Ticket_View_Query="select ticket_NO,show_Name,time,date,seat_NO,seat_class From Ticket";
}

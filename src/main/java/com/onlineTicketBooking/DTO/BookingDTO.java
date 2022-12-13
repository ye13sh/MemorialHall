package com.onlineTicketBooking.DTO;

public class BookingDTO {
    private String ticket_NO;
    private String show_Name;
    private String time;
    private String date;
    private String seat_NO;
    private String seat_class;


    public String getTicket_NO() {
        return ticket_NO;
    }

    public void setTicket_NO(String ticket_NO) {
        this.ticket_NO = ticket_NO;
    }

    public String getShow_Name() {
        return show_Name;
    }

    public void setShow_Name(String show_Name) {
        this.show_Name = show_Name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSeat_NO() {
        return seat_NO;
    }

    public void setSeat_NO(String seat_NO) {
        this.seat_NO = seat_NO;
    }

    public String getSeat_class() {
        return seat_class;
    }

    public void setSeat_class(String seat_class) {
        this.seat_class = seat_class;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "ticket_NO='" + ticket_NO + '\'' +
                ", show_Name='" + show_Name + '\'' +
                ", time='" + time + '\'' +
                ", date='" + date + '\'' +
                ", seat_NO='" + seat_NO + '\'' +
                ", seat_class='" + seat_class + '\'' +
                '}';
    }
}

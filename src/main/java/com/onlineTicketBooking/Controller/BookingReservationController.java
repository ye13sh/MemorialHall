package com.onlineTicketBooking.Controller;

import com.onlineTicketBooking.DTO.BookingDTO;
import com.onlineTicketBooking.Service.BookingReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookingReservationController{

    @Autowired
    BookingReservationService service;

    //ticket_NO,show_Name,time, date,seat_NO,seat_class;
    @RequestMapping(value = "/InsertTicket",method = RequestMethod.POST)
    public String InsertReserveSeat(Model model)throws Exception{
        try {
            System.out.println("InsertReserveSeat Controller Success");
            BookingDTO bookingDTO=new BookingDTO();
            bookingDTO.setShow_Name((String) model.getAttribute("show_Name"));
            bookingDTO.setTime((String) model.getAttribute("time"));
            bookingDTO.setDate((String) model.getAttribute("date"));
            bookingDTO.setSeat_NO((String) model.getAttribute("seat_NO"));
            bookingDTO.setSeat_class((String) model.getAttribute("seat_class"));

            String ticket=service.InsertReserveSeat(bookingDTO);
            model.addAttribute("ticket",ticket);

            return "Ticket_Insert_Success";
        }catch (Exception e){
            System.out.println("InsertReserveSeat Controller Exception"+""+e);
            return "Ticket_Insert_Exception";
        }
    }

    @RequestMapping(value = "/GetTicket",method = RequestMethod.GET)
    public String GetReserveSeatByTicketNo(Model model){
        try {
            System.out.println("GetReserveSeatByTicketNo Controller Success");
            BookingDTO ticket=service.GetReserveSeatByTicketNo((String) model.getAttribute("ticket_NO"));
            model.addAttribute("ticket",ticket);
            return "get_ticket_by_ticketNo";

        }catch (Exception e){
            System.out.println("GetReserveSeatByTicketNo Controller Exception"+""+e);
            return "get_ticket_Exception";
        }
    }

    @RequestMapping(value = "/DeleteTicket",method = RequestMethod.GET)
    public String DeleteReserveSeatByTicketNo(Model model){
        try {
            System.out.println("DeleteReserveSeatByTicketNo Controller Success");
            service.DeleteReserveSeatByTicketNo((String) model.getAttribute("ticket_NO"));
            return "delete_ticket_success";
        }catch (Exception e){
            System.out.println("DeleteReserveSeatByTicketNo Controller Exception"+""+e);
            return "delete_ticket_failure";
        }
    }

    //set time=?,date=?,seat_NO=?,seat_class=?
    @RequestMapping(value ="/InsertTicket",method = RequestMethod.POST)
    public String UpdateReserveSeatByTicketNo(Model model){
        try {
            System.out.println("UpdateReserveSeatByTicketNo Controller Success");
            BookingDTO bookingDTO=new BookingDTO();
            bookingDTO.setTime((String) model.getAttribute("time"));
            bookingDTO.setDate((String) model.getAttribute("date"));
            bookingDTO.setSeat_NO((String) model.getAttribute("seat_NO"));
            bookingDTO.setSeat_class((String) model.getAttribute("seat_class"));

            service.UpdateReserveSeatByTicketNo(bookingDTO);

            return "update_ticket_success";

        }catch (Exception e){
            System.out.println("UpdateReserveSeatByTicketNo Controller Exception"+""+e);
            return "update_ticket_failure";
        }
    }

    public String ViewReserveSeatTicket(Model model){
        try {

            return "";
        }catch (Exception e){
            return "";
        }
    }

}

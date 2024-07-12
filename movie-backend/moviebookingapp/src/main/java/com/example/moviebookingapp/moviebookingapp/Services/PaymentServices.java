package  org.com.movie_booking_system.com.movie_booking_system.services;

import com.example.movie_booking.repository.BookingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@Data
public class PaymentServices {
//  @PostMapping("/allMovie/")
    private BookingRepository bookingRepository;
}
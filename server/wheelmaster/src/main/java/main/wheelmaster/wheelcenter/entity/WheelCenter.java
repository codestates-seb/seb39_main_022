package main.wheelmaster.wheelcenter.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Builder
@ToString
@AllArgsConstructor
@Getter
public class WheelCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long centerId;
    private String cityName;
    private String facultyName;
    private String sigunguName;
    private String address;
    private Double latitude;
    private Double longitude;
    private String installLocation;

    @Column(columnDefinition = "TIME")
    private LocalTime weekdayOpenHour;
    @Column(columnDefinition = "TIME")
    private LocalTime weekdayCloseHour;
    @Column(columnDefinition = "TIME")
    private LocalTime satOpenHour;
    @Column(columnDefinition = "TIME")
    private LocalTime satCloseHour;
    @Column(columnDefinition = "TIME")
    private LocalTime holidayOpenHour;
    @Column(columnDefinition = "TIME")
    private LocalTime holidayCloseHour;

    private int simultaneousUser;
    private Boolean airInjectorFlag;
    private Boolean phoneChargerFlag;
    private String institutionName;
    private String institutionPhoneNumber;


}


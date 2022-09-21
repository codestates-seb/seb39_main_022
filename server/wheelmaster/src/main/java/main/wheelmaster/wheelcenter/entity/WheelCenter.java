package main.wheelmaster.wheelcenter.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WheelCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wheelCenterId;

    private String cityName; //도시이름
    private String facultyName; //시설명
    private String sigunguName;//구이름
    private String address;//도로명주소
    private Double latitude;//위도
    private Double longitude; //경도
    private String installLocation;//주입기구 설치 장소

    @Column(columnDefinition = "TIME")
    private LocalTime weekdayOpenHour;//주중 오픈 시간
    @Column(columnDefinition = "TIME")
    private LocalTime weekdayCloseHour;//주중 마감 시간
    @Column(columnDefinition = "TIME")
    private LocalTime satOpenHour;//토요일 오픈 시간
    @Column(columnDefinition = "TIME")
    private LocalTime satCloseHour;//토요일 마감 시간
    @Column(columnDefinition = "TIME")
    private LocalTime holidayOpenHour; //공휴일 오픈 시간
    @Column(columnDefinition = "TIME")
    private LocalTime holidayCloseHour;//공휴일 마감 시간

    private Integer simultaneousUser;//동시 사용 가능 개수
    private Boolean airInjectorFlag;//공기 주입기 사용 가능여부
    private Boolean phoneChargerFlag;//휴대정화 충전 가능여부
    private String institutionName;//관리기관명
    private String institutionPhoneNumber;//기관 전화번호


}


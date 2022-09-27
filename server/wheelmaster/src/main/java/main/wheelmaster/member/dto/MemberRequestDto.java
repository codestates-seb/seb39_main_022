package main.wheelmaster.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberRequestDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class singUpDto{
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z\\d_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z\\d.-]+$")
        private String email;

        @NotBlank
        @Length(min = 10)
        private String password;

        @NotBlank
        private String nickName;

        @NotBlank
        private String phoneNumber;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class loginDto {
        @NotBlank
        @Pattern(regexp = "^[a-zA-Z\\d_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z\\d.-]+$")
        private String email;
        @NotBlank
        private String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class updateDto{
        @Length(min = 10)
        private String password;

        private String nickName;

        private String phoneNumber;

        private long memberId;

        public updateDto setMemberId(long memberId){
            this.memberId = memberId;
            return this;
        }
    }
}
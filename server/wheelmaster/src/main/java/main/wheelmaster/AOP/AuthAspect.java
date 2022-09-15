//package main.wheelmaster.AOP;

//
//import lombok.RequiredArgsConstructor;
//import main.wheelmaster.member.service.MemberService;
//import main.wheelmaster.token.service.AuthService;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RequiredArgsConstructor
//@Aspect     // AOP Aspect
//@Component
//public class AuthAspect {
//
//    private static final String AUTHORIZATION = "accessToken";
//
//    private final AuthService authService;
//    private final MemberService memberService;
//    private final HttpServletRequest httpServletRequest;
//
//    @Around("@annotation(src.main.wheelmaster)");
//
//    public Object accessToken(final ProceedingJoinPoint pjp) throws Throwable{
//        try {
//            String accessToken = httpServletRequest.getHeader(AUTHORIZATION);
//            // HTTP Header 에서 AccessToken을 꺼냄
//
//            // Token 검증
//        }
//    }

//}

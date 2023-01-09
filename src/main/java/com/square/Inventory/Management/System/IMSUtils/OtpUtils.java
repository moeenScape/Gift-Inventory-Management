package com.square.Inventory.Management.System.IMSUtils;

import com.square.Inventory.Management.System.Entity.User;
import com.square.Inventory.Management.System.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class OtpUtils {
    private final UserRepository userRepository;

    public OtpUtils(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;

    public String generateOTP(User user) {
        int randomPin = (int) (Math.random()*9000) + 1000;

        return String.valueOf(randomPin);
    }

    public void clearOTP(User user) {
        user.setOtp(null);
        user.setSetOtpGenerationTime(null);
        userRepository.save(user);
    }

    public boolean isOtpExpired(User user) {
        long currentTimeInMillis = System.currentTimeMillis();
        long otpGenerationTime = user.getSetOtpGenerationTime().getTime();

        return otpGenerationTime + OTP_VALID_DURATION < currentTimeInMillis;
    }

}

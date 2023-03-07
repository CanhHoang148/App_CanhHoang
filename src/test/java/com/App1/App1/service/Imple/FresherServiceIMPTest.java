package com.App1.App1.service.Imple;

import com.App1.App1.model.entity.Fresher;
import com.App1.App1.repositories.FresherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FresherServiceIMPTest {
    @Mock
    FresherRepository fresherRepository;
    @InjectMocks
    FreServiceIMP freServiceIMP;
    private Fresher fresher;

    @BeforeEach
    void setUp(){
        fresher = new Fresher();
        fresher.setFresherId("2019121212");
        fresher.setFresherName("Lala");
        fresher.setFresherAddress("Thai Binh");
        fresher.setFresherPhone("0123123123");
        fresher.setFresherEmail("lala123@gmail.com");
    }
}

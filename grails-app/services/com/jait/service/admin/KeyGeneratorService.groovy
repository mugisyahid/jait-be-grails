package com.jait.service.admin

import com.jait.util.RandomString

import java.security.SecureRandom

class KeyGeneratorService {

    SecureRandom secureRandom = new SecureRandom()
    RandomString randomString = new RandomString(secureRandom, RandomString.upper + RandomString.lower)
    RandomString randomNumber = new RandomString(secureRandom, RandomString.digits)
    RandomString randomAlphaNumeric = new RandomString(secureRandom, RandomString.alphanum)

    String getStringKey(int length){
        randomString.nextRandom(length)
    }

    String getNumberKey(int length){
        randomNumber.nextRandom(length)
    }

    String getAlphaNumKey(int length){
        randomAlphaNumeric.nextRandom(length)
    }

}

package ua.qa.training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by osoboleva on 9/29/2016.
 */
public class PrimeTests {

    @Test
    public void testNonPrime(){
        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE-2));
    }

    @Test
    public void testPrimeInt(){
        Assert.assertTrue(Primes.isPrimeFast(Integer.MAX_VALUE));
    }

    @Test (enabled = false)
    public void testPrimeLong(){
        long n = Integer.MAX_VALUE;
        Assert.assertTrue(Primes.isPrime(n));
    }
}

import java.util.Arrays;

public class OlympicCandles {


    int countNight = 1;

    public int numberOfNights(int[] candles){
        if(checkIfOne(candles) < countNight){
            return countNight - 1;
        }
        boolean epsilon = true;
        Arrays.sort(candles);
        epsilon = false;
        for(int z = 1; z<= countNight; z++){
            int curindex = candles.length - z;
            candles[curindex] -= 1;
        }
        countNight ++;
        return numberOfNights(candles);
    }

    public int checkIfOne(int[] candleInput){
        int p = 0;
        boolean charlie = true;
        int howMany = 0;
        for(int q = 0; q < candleInput.length; q++){
            if(candleInput[q] > 0){
                howMany += 1;
            }
        }
        return howMany;
    }
}

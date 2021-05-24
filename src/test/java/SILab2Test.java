import org.junit.Test;

import java.security.Signature;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class SILab2Test {
    @Test
    public void multipleConditionTest(){
        RuntimeException exception;
        List<Time> timeList = new ArrayList<>(){};
        // List<Integer> result = new ArrayList<>();

        { // if (hr < 0 || hr > 24)

            // TX hr=-10, min=15, sec=20
            timeList.add(new Time(-10, 15, 20));
            exception = assertThrows(RuntimeException.class, () -> SILab2.function(timeList));
            assertEquals(exception.getMessage(), "The hours are smaller than the minimum");
            // F F hr=23, min=15, sec=20, опфатен во C1 тестирање
            // timeList.remove(0);
            // timeList.add(new Time(23, 15, 20));
            // result.add(83720);
            // assertEquals(result, SILab2.function(timeList));

            // FT hr=25, min=15, sec=20
            timeList.remove(0);
            timeList.add(new Time(26, 20, 10));
            exception = assertThrows(RuntimeException.class, () -> SILab2.function(timeList));
            assertEquals(exception.getMessage(), "The hours are grater than the maximum");
        }
        {//if (min < 0 || min > 59)

             //F T hr=15 min=60 sec=10
        timeList.remove(0);
        timeList.add(new Time(15,60,10));
        exception = assertThrows(RuntimeException.class,() -> SILab2.function(timeList));
        assertEquals(exception.getMessage(), "The minutes are not valid!");
            // F F ok, hr=23, min=15, sec=20 ,   опфатен во C1 тестирање

            // T X  hr=10 min=-1 sec=15
        timeList.remove(0);
        timeList.add(new Time(10,-1,15));
        exception = assertThrows(RuntimeException.class,() -> SILab2.function(timeList));
        assertEquals(exception.getMessage(), "The minutes are not valid!");
        }

        { // if  (sec >= 0 && sec <= 59)
            //T F hr=13, min = 12, sec=60.
            timeList.remove(0);
            timeList.add(new Time(13,12,60));
            exception = assertThrows(RuntimeException.class,() -> SILab2.function(timeList));
            assertEquals(exception.getMessage(),("The seconds are not valid!"));
            // T T ok,  опфатен погоре, hr=23, min=15, sec=20

            // F X  hr = 12, min=20, sec = -10
            timeList.remove(0);
            timeList.add(new Time(12,20,-10));
            exception = assertThrows(RuntimeException.class,() -> SILab2.function(timeList));
            assertEquals(exception.getMessage(), "The seconds are not valid!");
        }
        { // if (hr == 24 && min == 0 && sec == 0)
            // TTT  hr=24 min=0 sec=0 опфатен во подолу во C1 тестирање
            // timeList.remove(0);
            // timeList.add(new Time(24,0,0));
            // result.remove(0);
            // result.add(86400);
            // assertEquals(result,SILab2.function(timeList));

            // TTF hr=24 min=0 sec=12
            timeList.remove(0);
            timeList.add(new Time(24,0,12));
            exception = assertThrows(RuntimeException.class,() -> SILab2.function(timeList));
            assertEquals(exception.getMessage(), "The time is greater than the maximum");
            // TFX hr=24 min=12 sec=0
            timeList.remove(0);
            timeList.add(new Time(24,12,0));
            exception = assertThrows(RuntimeException.class,() -> SILab2.function(timeList));
            assertEquals(exception.getMessage(), "The time is greater than the maximum");
        }


    }
    @Test
    public void everyBranchTest(){

        //  ListTime = { new Time(hr=24 min=0 sec=0), new Time(hr=23, min=15, sec=20) }
        List<Time> listTime = new ArrayList<>();
        listTime.add(new Time(24 ,0 ,0));
        listTime.add(new Time(23,15,20) );
        List<Integer> result = new ArrayList<>(Arrays.asList(86400,83720));
        assertEquals(result, SILab2.function(listTime));
    }
}

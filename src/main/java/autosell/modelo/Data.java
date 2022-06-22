package autosell.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Data {
    private Calendar calendar;

    public Data(int dia, int mes, int ano) {
        this.calendar = new GregorianCalendar(ano, mes - 1, dia);
    }

    public static Data parseData(String data) {
        var formato = new SimpleDateFormat("dd/MM/yyyy");
        formato.setLenient(false);
        try {
            var date = formato.parse(data);
            var calendar = Calendar.getInstance();
            calendar.setTime(date);
            return new Data(
                    calendar.get(Calendar.DAY_OF_MONTH),
                    calendar.get(Calendar.MONTH) + 1,
                    calendar.get(Calendar.YEAR));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d",
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.YEAR));
    }

    public int compareTo(Data o1){
        return -calendar.compareTo(o1.calendar);
    }
}

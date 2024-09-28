

import androidx.room.TypeConverter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Converters {

    @TypeConverter
    public static String fromListToString(List<String> list) {
        return list.stream().collect(Collectors.joining(","));
    }

    @TypeConverter
    public static List<String> fromStringToList(String value) {
        return Arrays.asList(value.split(","));
    }
}

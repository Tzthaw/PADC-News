package com.padcmyanmar.sfc.database;

import android.arch.persistence.room.TypeConverter;

/**
 * Created by aung on 7/28/17.
 */

public class AttractionImagesTypeConverter {
    @TypeConverter
    public static String[] toStringArray(String images) {
        return images.split(",");
    }

    @TypeConverter
    public static String toString(String[] images) {
        if (images != null) {

            StringBuilder stringBuilder = new StringBuilder();
            for (String image : images) {
                stringBuilder.append(image).append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return stringBuilder.toString();
        }
        return "";
    }
}

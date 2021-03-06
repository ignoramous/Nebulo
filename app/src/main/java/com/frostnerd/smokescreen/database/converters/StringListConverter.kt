package com.frostnerd.smokescreen.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


/*
 * Copyright (C) 2019 Daniel Wolf (Ch4t4r)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * You can contact the developer at daniel.wolf@frostnerd.com.
 */
class StringListConverter {
    private val gson = Gson()
    private val type = object:TypeToken<List<String>>() {}.type

    @TypeConverter
    fun stringToList(value: String): List<String> {
        return if(value == "[]") emptyList()
        else gson.fromJson(value, type)
    }

    @TypeConverter
    fun someObjectListToString(value: List<String>): String {
        return if(value.isEmpty()) "[]"
        else gson.toJson(value)
    }
}
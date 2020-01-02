package ru.topjava.graduation.util.restaurant;

import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.model.dto.MealTo;

import java.util.List;
import java.util.stream.Collectors;

public class MealUtil {
    public static List<MealTo> mealTos(List<Meal> list) {
        return list.stream().map(MealTo::new).collect(Collectors.toList());
    }
}
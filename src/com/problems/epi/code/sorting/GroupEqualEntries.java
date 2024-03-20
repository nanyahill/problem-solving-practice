package com.problems.epi.code.sorting;

import java.util.*;

public class GroupEqualEntries {
    public static class Person {
        public Integer age;
        public String name;

        public Person(Integer k, String n) {
            age = k;
            name = n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Person person = (Person) o;

            if (!age.equals(person.age))
                return false;
            return name.equals(person.name);
        }

        @Override
        public int hashCode() {
            int result = age.hashCode();
            result = 31 * result + name.hashCode();
            return result;
        }
    }

    /**
     * This problem is solved using counting sort
     * (Step 1) Count frequencies of each letter using key as index.
     * (Step 2) Compute frequency cumulates which specify destinations.
     * (Step 3) Access cumulates using key as index to move items. (Can be done in place but will affect the stability of the algo)
     * (Step 4- skipped because in-place) Copy back into original array
     */
    public static void groupByAgeWithInPlaceMovementOfElements(List<Person> people) {

        Map<Integer, Integer> ageToCount = new TreeMap<>();
        for (Person p : people) {
            ageToCount.put(p.age, ageToCount.getOrDefault(p.age, 0) + 1);
        }
        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer, Integer> kc : ageToCount.entrySet()) {
            ageToOffset.put(kc.getKey(), offset);
            offset += kc.getValue();
        }

        while (!ageToOffset.isEmpty()) {
            Map.Entry<Integer, Integer> from =
                    ageToOffset.entrySet().iterator().next();
            Integer toAge = people.get(from.getValue()).age;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(people, from.getValue(), toValue);
            // Use ageToCount to see when we are finished with a particular age.
            Integer count = ageToCount.get(toAge) - 1;
            ageToCount.put(toAge, count);
            if (count > 0) {
                ageToOffset.put(toAge, toValue + 1);
            } else {
                ageToOffset.remove(toAge);
            }
        }
    }

    /**
     * This problem is solved using counting sort
     * (Step 1) Count frequencies of each letter using key as index.
     * (Step 2) Compute frequency cumulates which specify destinations.
     * (Step 3) Access cumulates using key as index to move items. (Can be done in place but will affect the stability of the algo)
     * (Step 4) Copy back into original array
     * Note:
     */
    public static void groupByAgeWithAuxStorageForMovementOfElements(List<Person> people) {

        Map<Integer, Integer> ageToCount = new TreeMap<>();
        for (Person p : people) {
            ageToCount.put(p.age, ageToCount.getOrDefault(p.age, 0) + 1);
        }
        Map<Integer, Integer> ageToOffset = new HashMap<>();
        int offset = 0;
        for (Map.Entry<Integer, Integer> kc : ageToCount.entrySet()) {
            ageToOffset.put(kc.getKey(), offset);
            offset += kc.getValue();
        }
        Person[] aux = new Person[people.size()];
        for (int i = 0; i < aux.length; i++) {
            int positionToPlaceElement = ageToOffset.get(people.get(i).age);
            aux[positionToPlaceElement] = people.get(i);
            int frequencyOfOccurrence = ageToCount.get(people.get(i).age) - 1;
            if (frequencyOfOccurrence > 0) ageToOffset.put(people.get(i).age, positionToPlaceElement + 1);
            else ageToOffset.remove(people.get(i).age);
        }
        for(int i = 0; i < aux.length; i++){
            people.set(i, aux[i]);
        }
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        String[][] array2D = {{"1", "Frank"}, {"3", "Peter"}, {"3", "Larry"}, {"2", "Thomas"}, {"3", "Larry"}, {"2", "Adam"}, {"3", "Jim"}, {"3", "Harry"}, {"2", "Xavier"}, {"3", "Sam"}, {"3", "Oliver"}};
        String[][] array2D2 = {{"100", "Test"}, {"14", "Greg"}, {"12", "Jim"}, {"11", "Larry"}, {"13", "Thomas"}, {"12", "LarryB"}, {"13", "Adam"}, {"13", "Chip"}, {"14", "Tim"}};
        for(String[] str : array2D2) {
            persons.add(new Person(Integer.parseInt(str[0]), str[1]));
        }
        groupByAgeWithAuxStorageForMovementOfElements(persons);
        System.out.println(Arrays.asList(persons));

    }
}

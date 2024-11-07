package Sandro.Week8.Person2;

import java.util.List;

public class PersonStatistics {
    private MinMaxAvg height;
    private MinMaxAvg age;
    private MinMaxAvg weight;

    public MinMaxAvg getAge() {
        return age;
    }

    public MinMaxAvg getHeight() {
        return height;
    }

    public MinMaxAvg getWeight() {
        return weight;
    }

    public static PersonStatistics calculate(List<Person> persons) {
        Person firstPerson = persons.get(0);
        MinMaxAvg age = new MinMaxAvg();
        age.setMin(firstPerson.getAge());
        age.setMax(firstPerson.getAge());
        MinMaxAvg height = new MinMaxAvg();
        height.setMin(firstPerson.getHeight());
        height.setMax(firstPerson.getHeight());
        MinMaxAvg weight = new MinMaxAvg();
        weight.setMin(firstPerson.getWeight());
        weight.setMax(firstPerson.getWeight());

        int sumA = 0;
        int sumW = 0;
        int sumH = 0;

        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);
            if(p.getAge() < age.getMin()) {
            age.setMin(p.getAge());
            }
            if(p.getAge() > age.getMax()){
                age.setMax(p.getAge());
            }
            sumA += p.getAge();

            if(p.getWeight() < weight.getMin()) {
                weight.setMin(p.getWeight());
            }
            if(p.getWeight() > weight.getMax()){
                weight.setMax(p.getWeight());
            }
            sumW += p.getWeight();

            if(p.getHeight() < height.getMin()) {
                height.setMin(p.getHeight());
            }
            if(p.getHeight() > height.getMax()){
                height.setMax(p.getHeight());
            }
            sumH += p.getHeight();

        }
        age.setAvg((double)sumA / persons.size());
        height.setAvg((double)sumH / persons.size());
        weight.setAvg((double) sumW / persons.size());

        PersonStatistics statistics = new PersonStatistics();
        statistics.age = age;
        statistics.height = height;
        statistics.weight = weight;

        return statistics;
    }


    @Override
    public String toString() {
        return "PersonStatistics\n" +
                "height=" + height +
                "\nage=" + age +
                "\nweight=" + weight
                ;
    }
}

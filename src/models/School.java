package models;

import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> participants;

    public School() {
        participants = new ArrayList<>();
    }

    public void addParticipant(Person person) {
        participants.add(person);
    }

    public Person getParticipant(int index) { return participants.get(index); }

    public List<Person> getParticipants() {
        return participants;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Person participant : participants) {
            result.append(participant.toString()).append("\n");
        }
        return result.toString();
    }
}

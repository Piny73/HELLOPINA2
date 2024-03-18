package CrowdGraderRoom;

import java.time.LocalDate;

public class Reservation {

    private final String nome;
    private final LocalDate from;
    private final LocalDate to;

    public Reservation(String nome, LocalDate from, LocalDate to) {
        this.nome = nome;
        this.from = from;
        this.to = to;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Reservation other = (Reservation) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from))
            return false;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Room [nome=" + nome + ", inPre=" + from + ", outPre=" + to + "]";
    }

    public boolean isOverlapped(LocalDate f, LocalDate t) {
        return from.isReserved(d) || from.isReserved(d) || (to.isBefore(from) || to.isAfter(to));
       
    }
    private boolean isReserved(LocalDate d){
        return from.isEqual(d) || to.isEqual(d) || (d.isAfter(from) && d.isBefore(to));
    }

}

package com.javarush.task.task24.task2406;

import java.math.BigDecimal;

/* 
Наследование от внутреннего класса
*/
public class Solution {
    public class Building {
        public class Hall  extends Building{
            private BigDecimal square;

            public Hall() {
            }

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments extends Building{
        }
    }
    public class Apt3Bedroom extends Building.Apartments {
        public Apt3Bedroom(Building.Apartments apartments) {
            apartments.super();
        }
    }
    public class BigHall extends Building.Hall{

    /*    public BigHall(BigDecimal square) {
            super(square);
        }*/
        public BigHall(Building.Hall hall) {
           hall.super();
        }
    }

    public static void main(String[] args) {

    }
}

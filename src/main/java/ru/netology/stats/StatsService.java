package ru.netology.stats;

public class StatsService {
    public long sum(long[] sales) {
        long totalSale = 0;
        for (long sale : sales) {
            totalSale += sale;
        }
        return totalSale;
    }

    public long average(long[] sales) {
        return sum(sales) / sales.length;
    }

    public int monthMaxSale(long[] sales) {
        int monthMax = 0;
        long saleMax = sales[0];
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] >= saleMax) {
                monthMax = i;
                saleMax = sales[i];
            }
        }
        return monthMax + 1;
    }

    public int minSales(long[] sales) {
        int minMonth = 0; // номер месяца с минимальными продажами среди просмотренных ранее

        for (int i = 0; i < sales.length; i++) {
            if (sales[i] <= sales[minMonth]) { // значит, в рассматриваемом i-м месяце продаж меньше
                minMonth = i; // запомним его как минимальный
            }
        }

        return minMonth + 1; // месяца нумеруются с 1, а индексы массива с 0, нужно сдвинуть ответ на 1
    }

    public int monthsBellowAverage(long[] sales) {
        int counter = 0;
        long averageSale = average(sales);

        for (long sale : sales) {
            if (sale < averageSale) {
                counter++;
            }
        }
        return counter;
    }

    public int monthsUnderAverage(long[] sales) {
        int counter = 0;
        long averageSale = average(sales);

        for (long sale : sales) {
            if (sale > averageSale) {
                counter++;
            }
        }
        return counter;
    }
}

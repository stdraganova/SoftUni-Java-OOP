package interfacesandabstraction.exercise.defineaninterfaceperson.telephony;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Smartphone implements Callable, Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    public List<String> getNumbers() {
        return numbers;
    }

    public List<String> getUrls() {
        return urls;
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        urls.stream().forEach(url -> {
            boolean containsDigits = false;
            for (int i = 0; i < url.length() - 1; i++) {
                if (Character.isDigit(url.charAt(i))){
                    containsDigits = true;
                }
            }

            if (containsDigits == true){
                sb.append("Invalid URL!").append(System.lineSeparator());
            }else {
                sb.append("Browsing: " + url + "!").append(System.lineSeparator());
            }

        });

        return sb.toString().trim();
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        AtomicBoolean isNotValid = new AtomicBoolean(false);
        numbers.stream().forEach(number -> {
            for (int i = 0; i < number.length(); i++) {
                if (!Character.isDigit(number.charAt(i))){
                    isNotValid.set(true);
                }
            }
            if (isNotValid.get() == true){
                sb.append("Invalid number!").append(System.lineSeparator());
            }else {
                sb.append("Calling... " + number).append(System.lineSeparator());
            }

        });

        return sb.toString().trim();
    }
}

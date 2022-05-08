package onl.gcm.distantworld.view;

import java.util.Arrays;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class DivBuilder {

    private Div div;

    public static DivBuilder create() {
        return new DivBuilder();
    }

    public Div build() {
        return div;
    }

    public DivBuilder setText(String text) {
        div.setText(text);
        return this;
    }

    public DivBuilder setColor(String color) {
        div.getStyle().set("color", color);
        return this;
    }

    public DivBuilder add(Component... components) {
        Arrays.stream(components).forEach(div::add);
        return this;
    }

    // Private constructor to prevent manual instantiation.
    private DivBuilder() {
        div = new Div();
    }

}

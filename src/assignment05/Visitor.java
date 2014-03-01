package assignment05;

public interface Visitor {
    void visit(MenuPart part);
    void visit(MenuAbstraction abstraction);
    void visit(Menu menu);
}

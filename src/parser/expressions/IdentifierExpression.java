package parser.expressions;

public class IdentifierExpression implements Expression {
  public final String identifier;

  public IdentifierExpression(String identifier) {
    this.identifier = identifier;
  }

  @Override
  public String debug() {
    return String.format("IdentifierExpression(%s)", identifier);
  }
}

package parser.expressions;

import lexer.TokenType;

public class PrefixExpression implements Expression {
  public final TokenType tokenType;
  public final Expression operand;

  public PrefixExpression(TokenType tokenType, Expression operand) {
    this.tokenType = tokenType;
    this.operand = operand;
  }

  @Override
  public String debug() {
    return String.format("PrefixExpression(%s %s)", tokenType.toString(), operand.debug());
  }
}

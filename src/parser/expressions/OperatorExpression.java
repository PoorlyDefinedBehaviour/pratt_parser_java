package parser.expressions;

import lexer.TokenType;

public class OperatorExpression implements Expression {
  public final Expression left;
  public final TokenType tokenType;
  public final Expression right;

  public OperatorExpression(Expression left, TokenType tokenType, Expression right) {
    this.left = left;
    this.tokenType = tokenType;
    this.right = right;
  }

  @Override
  public String debug() {
    return String.format("OperatorExpression(%s %s %s)", left.debug(), tokenType.toString(), right.debug());
  }
}

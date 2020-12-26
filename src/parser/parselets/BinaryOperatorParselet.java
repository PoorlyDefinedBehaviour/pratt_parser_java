package parser.parselets;

import lexer.Token;
import parser.Parser;
import parser.expressions.Expression;
import parser.expressions.OperatorExpression;

public class BinaryOperatorParselet implements InfixParselet {
  int precedence;

  public BinaryOperatorParselet(int precedence) {
    this.precedence = precedence;
  }

  @Override
  public int getPrecedence() {
    return precedence;
  }

  @Override
  public Expression parse(Parser parser, Expression left, Token token) {
    Expression right = parser.parseExpression(getPrecedence());

    return new OperatorExpression(left, token.type, right);
  }
}

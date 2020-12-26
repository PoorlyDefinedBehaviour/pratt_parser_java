package parser.parselets;

import lexer.Token;
import parser.Parser;
import parser.Precedence;
import parser.expressions.Expression;
import parser.expressions.OperatorExpression;

public class BinaryTermOperatorParselet implements InfixParselet {
  @Override
  public int getPrecedence() {
    return Precedence.TERM;
  }

  @Override
  public Expression parse(Parser parser, Expression left, Token token) {
    Expression right = parser.parseExpression(getPrecedence());

    return new OperatorExpression(left, token.type, right);
  }
}

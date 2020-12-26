package parser.parselets;

import lexer.Token;
import parser.*;
import parser.expressions.Expression;
import parser.expressions.PrefixExpression;

public class PrefixOperatorParselet implements PrefixParselet {

  @Override
  public Expression parse(Parser parser, Token token) {
    Expression operand = parser.parseExpression(Precedence.UNARY);

    return new PrefixExpression(token.type, operand);
  }
}

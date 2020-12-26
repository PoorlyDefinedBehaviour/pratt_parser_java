package parser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lexer.*;
import parser.expressions.*;
import parser.parselets.*;

public class Parser {
  private int currentPosition = 0;
  private final List<Token> tokens;
  private final HashMap<TokenType, PrefixParselet> prefixParselets = new HashMap<>();
  private final HashMap<TokenType, InfixParselet> infixParselets = new HashMap<>();

  public Parser(List<Token> tokens) {
    this.tokens = tokens;

    prefixParselets.put(TokenType.IDENTIFIER, new IdentifierParselet());
    prefixParselets.put(TokenType.MINUS, new PrefixOperatorParselet());

    infixParselets.put(TokenType.PLUS, new BinaryOperatorParselet(Precedence.TERM));
    infixParselets.put(TokenType.STAR, new BinaryOperatorParselet(Precedence.FACTOR));
  }

  private boolean hasTokensToParse() {
    return currentPosition < tokens.size() - 1;
  }

  private Token consume() {
    Token token = tokens.get(currentPosition);

    currentPosition += 1;

    return token;
  }

  private Token lookAhead(int offset) {
    return tokens.get(currentPosition + offset);
  }

  private int currentTokenPrecedence() {
    InfixParselet infixParselet = infixParselets.get(lookAhead(0).type);

    if (infixParselet == null) {
      return Precedence.NONE;
    }

    return infixParselet.getPrecedence();
  }

  public Expression parseExpression(int precedence) {
    Token token = consume();

    PrefixParselet prefixParselet = prefixParselets.get(token.type);

    Expression left = prefixParselet.parse(this, token);

    while (hasTokensToParse() && precedence < currentTokenPrecedence()) {
      token = consume();

      InfixParselet infixParselet = infixParselets.get(token.type);

      left = infixParselet.parse(this, left, token);
    }

    return left;
  }

  public List<Expression> parse() {
    List<Expression> expressions = new ArrayList<>();

    while (hasTokensToParse()) {
      expressions.add(parseExpression(Precedence.NONE));
    }

    return expressions;
  }
}

import java.util.ArrayList;
import java.util.List;

import lexer.Token;
import lexer.TokenType;
import parser.Parser;
import parser.expressions.Expression;

public class Main {
  public static void main(String[] args) {
    List<Token> tokens = new ArrayList<>();

    tokens.add(new Token(TokenType.MINUS, "-"));
    tokens.add(new Token(TokenType.IDENTIFIER, "x"));
    tokens.add(new Token(TokenType.PLUS, "+"));
    tokens.add(new Token(TokenType.IDENTIFIER, "y"));
    tokens.add(new Token(TokenType.STAR, "*"));
    tokens.add(new Token(TokenType.IDENTIFIER, "z"));

    Parser parser = new Parser(tokens);

    List<Expression> expressions = parser.parse();

    System.out.println(expressions.get(0).debug());
  }
}
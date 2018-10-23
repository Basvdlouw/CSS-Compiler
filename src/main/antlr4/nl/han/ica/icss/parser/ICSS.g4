grammar ICSS;

//--- PARSER: ---

//stylesheet: identifier+;
//identifier: LOWER_IDENT | CAPITAL_IDENT | ID_IDENT | CLASS_IDENT;
//statement: OPEN_BRACE values CLOSE_BRACE;
//values: LOWER_IDENT COLON COLOR;

@header{
package nl.han.ica.icss.parser;
}

stylesheet: stylesheetPart*;
stylesheetPart: stylerule;
stylerule: identifier OPEN_BRACE declaration+ CLOSE_BRACE;
declaration: LOWER_IDENT COLON expression;
expression: value | operation;
value: PIXELSIZE SEMICOLON | PERCENTAGE SEMICOLON | SCALAR SEMICOLON | COLOR SEMICOLON;
operation: value operator value;
operator: PLUS | MIN | MUL;
identifier: LOWER_IDENT | CLASS_IDENT | ID_IDENT;


//--- LEXER: ---

//Literals
PIXELSIZE: [0-9]+ 'px';
PERCENTAGE: [0-9]+ '%';
SCALAR: [0-9]+;

//Color value takes precedence over id idents
COLOR: '#' [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f] [0-9a-f];

//Specific identifiers for id's and css classes
ID_IDENT: '#' [a-z0-9\-]+;
CLASS_IDENT: '.' [a-z0-9\-]+;

//General identifiers
LOWER_IDENT: [a-z0-9\-]+;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespace is skipped
WS: [ \t\r\n]+ -> skip;

//
OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';


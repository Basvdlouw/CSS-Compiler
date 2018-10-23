grammar ICSS;

//--- PARSER: ---

stylesheet: stylesheetPart*;
variableAssignment: variableReference ASSIGNMENT_OPERATOR expression SEMICOLON;
stylerule:
    selector OPEN_BRACE declaration+ CLOSE_BRACE
    | selector OPEN_BRACE declaration* stylerule+ CLOSE_BRACE;

stylesheetPart:
    stylerule
    | variableAssignment;

declaration:
    propertyAssignment
    | variableAssignment;

propertyAssignment:
    property COLON expression SEMICOLON
    | property COLON variableReference SEMICOLON;

expression:
    literal
    | operation;

operation:
    literal #literalInOperation
    | variableReference #variableInOperation
    | operation MUL operation #multiplication
    | operation PLUS operation #addition
    | operation MIN operation #inversiveAddition;

property:
    LOWER_IDENT;

literal:
    PIXELSIZE #pixelLiteral
    | PERCENTAGE #percentageLiteral
    | SCALAR #scalarLiteral
    | COLOR #colorLiteral;

selector:
    LOWER_IDENT #tagSelector
    | CLASS_IDENT #classSelector
    | ID_IDENT #idSelector;

variableReference:
    CAPITAL_IDENT;

//--- LEXER: ---

OPEN_BRACE: '{';
CLOSE_BRACE: '}';
SEMICOLON: ';';
COLON: ':';
PLUS: '+';
MIN: '-';
MUL: '*';
ASSIGNMENT_OPERATOR: ':=';

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
LOWER_IDENT: [a-z] [a-z0-9\-]*;
CAPITAL_IDENT: [A-Z] [A-Za-z0-9_]*;

//All whitespace is skipped
WS: [ \t\r\n]+ -> skip;

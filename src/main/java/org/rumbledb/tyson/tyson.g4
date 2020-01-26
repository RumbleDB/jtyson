/* building on grammar for json found on https://github.com/antlr/grammars-v4/blob/master/json/JSON.g4 */

grammar tyson;

options{
	language = 'Java';
}

tyson
	: annotatedValue
	;

annotatedValue
	: value
	| '('typeName=STRING')' value
	;

obj
   : '{' pairlst+=pair (',' pairlst+=pair)* '}'
   | '{' '}'
   ;

pair
   : key=STRING ':' annotatedValue
   ;

array
   : '[' arlst+=annotatedValue (',' arlst+=annotatedValue)* ']'
   | '[' ']'
   ;
   

number
   : '-'? INT 
   | '-'? DECIMAL
   | '-'? DOUBLE
   ;

value
   : str=STRING
   | number
   | obj
   | array
   | 'true'
   | 'false'
   | 'null'
   ;


STRING
   : '"' (ESC | SAFECODEPOINT)* '"'
   ;


fragment ESC
   : '\\' (["\\/bfnrt] | UNICODE)
   ;
fragment UNICODE
   : 'u' HEX HEX HEX HEX
   ;
fragment HEX
   : [0-9a-fA-F]
   ;
fragment SAFECODEPOINT
   : ~ ["\\\u0000-\u001F]
   ;


DECIMAL
	: INT '.' [0-9]+
	;
	
DOUBLE
	: INT EXP
	;


INT
   : '0' | [1-9] [0-9]*
   ;

// no leading zeros

fragment EXP
   : [Ee] [+\-]? INT
   ;

// \- since - means "range" inside [...]

WS
   : [ \t\n\r] + -> skip
   ;
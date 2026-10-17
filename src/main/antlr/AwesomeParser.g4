parser grammar AwesomeParser;
options {
    tokenVocab = AwesomeLexer;
//    superClass = ArgumentParser;
}

@header{
}

start : expr EOF ;

expr : left=expr PLUS right=expr #AddExpr
     | literal                  #LiteralExpr
     ;

literal : INT | DOUBLE ;

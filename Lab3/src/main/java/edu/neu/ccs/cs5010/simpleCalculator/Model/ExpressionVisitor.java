package edu.neu.ccs.cs5010.simpleCalculator.Model;

interface ExpressionVisitor {
  void visit(Op op);
  void visit(Val val);
}

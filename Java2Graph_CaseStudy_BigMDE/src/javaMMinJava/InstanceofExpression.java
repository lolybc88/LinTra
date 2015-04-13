
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class InstanceofExpression  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			TypeAccess rightOperand; Boolean rightOperandIsComposed = true;
			
			Expression leftOperand; Boolean leftOperandIsComposed = true;
			
			
			public InstanceofExpression(){ }
			
			
			public InstanceofExpression(
				String id,				
				
				Comment[] comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				TypeAccess rightOperand,				Expression leftOperand ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.rightOperand = rightOperand ;
				this.leftOperand = leftOperand ;
			}
			
			
			
			public String getId() {
   				return id;
			}

			public void setId(String id) {
   				this.id = id;
			}
			
			public String getTrgId() {
   				return trgId;
			}

			public void setTrgId(String trgId) {
   				this.trgId = trgId;
			}
			
			
			
			
			
			public void setRightOperand(TypeAccess rightOperand) {
				this.rightOperand = rightOperand;
			}
				
			public TypeAccess getRightOperand() {
				return rightOperand;
			}
			
			public void setLeftOperand(Expression leftOperand) {
				this.leftOperand = leftOperand;
			}
				
			public Expression getLeftOperand() {
				return leftOperand;
			}
			
		}
	
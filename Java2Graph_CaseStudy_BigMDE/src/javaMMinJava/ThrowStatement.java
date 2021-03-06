
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class ThrowStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			Expression expression; Boolean expressionIsComposed = true;
			
			
			public ThrowStatement(){ }
			
			
			public ThrowStatement(
				String id,				
				
				Comment[] comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression expression ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.expression = expression ;
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
			
			
			
			
			
			public void setExpression(Expression expression) {
				this.expression = expression;
			}
				
			public Expression getExpression() {
				return expression;
			}
			
		}
	
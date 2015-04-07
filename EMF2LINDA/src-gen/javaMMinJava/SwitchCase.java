
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class SwitchCase  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			Boolean default;
			
			
			Expression expression; Boolean expressionIsComposed = true;
			
			
			public SwitchCase(){ }
			
			
			public SwitchCase(
				String id,				
				Boolean default
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				Expression expression ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				this.default = default ;
				
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
			
			
			
			public void setDefault(Boolean default) {
				this.default = default;
			}
				
			public Boolean getDefault() {
				return default;
			}
			
			
			
			public void setExpression(Expression expression) {
				this.expression = expression;
			}
				
			public Expression getExpression() {
				return expression;
			}
			
		}
	
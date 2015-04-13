
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class FieldAccess  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			SingleVariableAccess field; Boolean fieldIsComposed = true;
			
			Expression expression; Boolean expressionIsComposed = true;
			
			
			public FieldAccess(){ }
			
			
			public FieldAccess(
				String id,				
				
				Comment[] comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				SingleVariableAccess field,				Expression expression ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.field = field ;
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
			
			
			
			
			
			public void setField(SingleVariableAccess field) {
				this.field = field;
			}
				
			public SingleVariableAccess getField() {
				return field;
			}
			
			public void setExpression(Expression expression) {
				this.expression = expression;
			}
				
			public Expression getExpression() {
				return expression;
			}
			
		}
	
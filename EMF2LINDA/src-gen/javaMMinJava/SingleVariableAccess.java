
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class SingleVariableAccess  extends Expression implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			VariableDeclaration variable; Boolean variableIsComposed = false;
			
			Expression qualifier; Boolean qualifierIsComposed = true;
			
			
			public SingleVariableAccess(){ }
			
			
			public SingleVariableAccess(
				String id,				
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				VariableDeclaration variable,				Expression qualifier ){
				
				super(				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.variable = variable ;
				this.qualifier = qualifier ;
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
			
			
			
			
			
			public void setVariable(VariableDeclaration variable) {
				this.variable = variable;
			}
				
			public VariableDeclaration getVariable() {
				return variable;
			}
			
			public void setQualifier(Expression qualifier) {
				this.qualifier = qualifier;
			}
				
			public Expression getQualifier() {
				return qualifier;
			}
			
		}
	

		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class MethodRef  extends ASTNode implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			AbstractMethodDeclaration method; Boolean methodIsComposed = false;
			
			TypeAccess qualifier; Boolean qualifierIsComposed = true;
			
			MethodRefParameter parameters; Boolean parametersIsComposed = true;
			
			
			public MethodRef(){ }
			
			
			public MethodRef(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				AbstractMethodDeclaration method,				TypeAccess qualifier,				MethodRefParameter parameters ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.method = method ;
				this.qualifier = qualifier ;
				this.parameters = parameters ;
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
			
			
			
			
			
			public void setMethod(AbstractMethodDeclaration method) {
				this.method = method;
			}
				
			public AbstractMethodDeclaration getMethod() {
				return method;
			}
			
			public void setQualifier(TypeAccess qualifier) {
				this.qualifier = qualifier;
			}
				
			public TypeAccess getQualifier() {
				return qualifier;
			}
			
			public void setParameters(MethodRefParameter parameters) {
				this.parameters = parameters;
			}
				
			public MethodRefParameter getParameters() {
				return parameters;
			}
			
		}
	
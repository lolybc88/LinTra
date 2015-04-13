
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;

import java.io.Serializable;
	
		public  class ConstructorInvocation  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			AbstractMethodDeclaration method;
			Boolean methodIsComposed = false;

			Expression[] arguments;
			Boolean argumentsIsComposed = true;

			TypeAccess[] typeArguments;
			Boolean typeArgumentsIsComposed = true;
			
			
			
			public ConstructorInvocation(){ }
			
			
			public ConstructorInvocation(
String id,

	Comment[] comments, CompilationUnit originalCompilationUnit,
			ClassFile originalClassFile, AbstractMethodDeclaration method,
			Expression[] arguments, TypeAccess[] typeArguments) {

		super(comments, originalCompilationUnit,			originalClassFile);
				
				this.id = id;
				this.method = method;
				this.arguments = arguments;
				this.typeArguments = typeArguments;
				
				
				
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

			public void setArguments(Expression[] arguments) {
				this.arguments = arguments;
			}

			public Expression[] getArguments() {
				return arguments;
			}

			public void setTypeArguments(TypeAccess[] typeArguments) {
				this.typeArguments = typeArguments;
			}

			public TypeAccess[] getTypeArguments() {
				return typeArguments;
			}
			
			
			
			
			
		}
	
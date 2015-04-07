
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class TypeDeclarationStatement  extends Statement implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			AbstractTypeDeclaration declaration; Boolean declarationIsComposed = true;
			
			
			public TypeDeclarationStatement(){ }
			
			
			public TypeDeclarationStatement(
				String id,				
				
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				AbstractTypeDeclaration declaration ){
				
				super(				
				comments
				,				originalCompilationUnit
				,				originalClassFile
);
				
				this.id = id;
				
				
				
				this.declaration = declaration ;
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
			
			
			
			
			
			public void setDeclaration(AbstractTypeDeclaration declaration) {
				this.declaration = declaration;
			}
				
			public AbstractTypeDeclaration getDeclaration() {
				return declaration;
			}
			
		}
	
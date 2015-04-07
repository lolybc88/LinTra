
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class UnresolvedTypeDeclaration  extends AbstractTypeDeclaration implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			
			public UnresolvedTypeDeclaration(){ }
			
			
			public UnresolvedTypeDeclaration(
				String id,				
				String name,				Boolean proxy
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				AbstractTypeDeclaration abstractTypeDeclaration,				Annotation annotations,				AnonymousClassDeclaration anonymousClassDeclarationOwner,				Modifier modifier,				TypeAccess usagesInTypeAccess,				BodyDeclaration bodyDeclarations,				Comment commentsBeforeBody,				Comment commentsAfterBody,				Package package,				TypeAccess superInterfaces ){
				
				super(				name,				proxy				,
				comments
				,				originalCompilationUnit
				,				originalClassFile
				,				usagesInImports
				,				abstractTypeDeclaration
				,				annotations
				,				anonymousClassDeclarationOwner
				,				modifier
				,				usagesInTypeAccess
				,				bodyDeclarations
				,				commentsBeforeBody
				,				commentsAfterBody
				,				package
				,				superInterfaces
);
				
				this.id = id;
				
				
				
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
			
			
			
			
			
		}
	
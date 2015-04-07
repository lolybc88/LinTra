
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public  class EnumDeclaration  extends AbstractTypeDeclaration implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			String id, trgId;
			
			
			
			
			EnumConstantDeclaration enumConstants; Boolean enumConstantsIsComposed = true;
			
			
			public EnumDeclaration(){ }
			
			
			public EnumDeclaration(
				String id,				
				String name,				Boolean proxy
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				AbstractTypeDeclaration abstractTypeDeclaration,				Annotation annotations,				AnonymousClassDeclaration anonymousClassDeclarationOwner,				Modifier modifier,				TypeAccess usagesInTypeAccess,				BodyDeclaration bodyDeclarations,				Comment commentsBeforeBody,				Comment commentsAfterBody,				Package package,				TypeAccess superInterfaces,				EnumConstantDeclaration enumConstants ){
				
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
				
				
				
				this.enumConstants = enumConstants ;
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
			
			
			
			
			
			public void setEnumConstants(EnumConstantDeclaration enumConstants) {
				this.enumConstants = enumConstants;
			}
				
			public EnumConstantDeclaration getEnumConstants() {
				return enumConstants;
			}
			
		}
	
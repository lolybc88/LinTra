
		package javaMMinJava;
		
		import blackboard.IdentifiableElement;
		import java.io.Serializable;
	
		public abstract class TypeDeclaration  extends AbstractTypeDeclaration implements Serializable, IdentifiableElement {
			
			private static final long serialVersionUID = 1L;
			
			
			
			
			
			
			TypeParameter typeParameters; Boolean typeParametersIsComposed = true;
			
			
			public TypeDeclaration(){ }
			
			
			public TypeDeclaration(
				
				String name,				Boolean proxy
				,
				Comment comments,				CompilationUnit originalCompilationUnit,				ClassFile originalClassFile,				ImportDeclaration usagesInImports,				AbstractTypeDeclaration abstractTypeDeclaration,				Annotation annotations,				AnonymousClassDeclaration anonymousClassDeclarationOwner,				Modifier modifier,				TypeAccess usagesInTypeAccess,				BodyDeclaration bodyDeclarations,				Comment commentsBeforeBody,				Comment commentsAfterBody,				Package package_,				TypeAccess superInterfaces,				TypeParameter typeParameters ){
				
		super(name, proxy, comments, originalCompilationUnit,
				originalClassFile, usagesInImports, abstractTypeDeclaration,
				annotations, anonymousClassDeclarationOwner, modifier,
				usagesInTypeAccess, bodyDeclarations, commentsBeforeBody,
				commentsAfterBody, package_, superInterfaces);
				
				
				
				
				
				this.typeParameters = typeParameters ;
			}
			
			
			
			
			
			
			
			public void setTypeParameters(TypeParameter typeParameters) {
				this.typeParameters = typeParameters;
			}
				
			public TypeParameter getTypeParameters() {
				return typeParameters;
			}
			
		}
	
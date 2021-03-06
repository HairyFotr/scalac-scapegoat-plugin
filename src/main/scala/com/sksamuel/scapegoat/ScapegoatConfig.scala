package com.sksamuel.scapegoat

import com.sksamuel.scapegoat.inspections._
import com.sksamuel.scapegoat.inspections.collections._
import com.sksamuel.scapegoat.inspections.controlflow.WhileTrue
import com.sksamuel.scapegoat.inspections.empty._
import com.sksamuel.scapegoat.inspections.equality.{ComparingFloatingPointTypes, ComparingUnrelatedTypes, ComparisonWithSelf}
import com.sksamuel.scapegoat.inspections.exception.{IncorrectlyNamedExceptions, UnreachableCatch, CatchThrowable, CatchNpe}
import com.sksamuel.scapegoat.inspections.inference.{PointlessTypeBounds, MethodReturningAny, BoundedByFinalType, ProductWithSerializableInferred}
import com.sksamuel.scapegoat.inspections.matching.{SuspiciousMatchOnClassObject, PartialFunctionInsteadOfMatch, RepeatedCaseBody}
import com.sksamuel.scapegoat.inspections.math._
import com.sksamuel.scapegoat.inspections.naming.{ObjectNames, ClassNames}
import com.sksamuel.scapegoat.inspections.option.{EitherGet, ImpossibleOptionSizeCondition, OptionGet, OptionSize}
import com.sksamuel.scapegoat.inspections.string._
import com.sksamuel.scapegoat.inspections.style.{AvoidOperatorOverload, ParameterlessMethodReturnsUnit, SimplifyBooleanExpression}
import com.sksamuel.scapegoat.inspections.unneccesary._
import com.sksamuel.scapegoat.inspections.unsafe._

/** @author Stephen Samuel */
object ScapegoatConfig extends App {

  def inspections: Seq[Inspection] = Seq(
    new ArrayEquals,
    new ArraysInFormat,
    new ArraysToString,
    new AvoidOperatorOverload,
    new AvoidSizeEqualsZero,
    new AvoidSizeNotEqualsZero,
    new AvoidToMinusOne,
    new AsInstanceOf,
    new BigDecimalDoubleConstructor,
    new BoundedByFinalType,
    new BrokenOddness,
    new CatchNpe,
    new CatchThrowable,
    new ClassNames,
    new CollectionNamingConfusion,
    new CollectionNegativeIndex,
    new CollectionPromotionToAny,
    new ComparingFloatingPointTypes,
    new ComparingUnrelatedTypes,
    new ComparisonToEmptyList,
    new ComparisonWithSelf,
    new ConstantIf,
    new DivideByOne,
    new DoubleNegation,
    new DuplicateImport,
    new DuplicateMapKey,
    new DuplicateSetValue,
    new EitherGet,
    new EmptyCaseClass,
    new EmptyCatchBlock,
    new EmptyFor,
    new EmptyIfBlock,
    new EmptyInterpolatedString,
    new EmptyMethod,
    new EmptySynchronizedBlock,
    new EmptyTryBlock,
    new EmptyWhileBlock,
    new ExistsSimplifableToContains,
    // new ExpressionAsStatement,
    new FilterDotHead,
    new FilterDotHeadOption,
    new FilterDotIsEmpty,
    new FilterOptionAndGet,
    new FilterDotSize,
    new FinalizerWithoutSuper,
    new FindDotIsDefined,
    new IllegalFormatString,
    new IncorrectlyNamedExceptions,
    new IncorrectNumberOfArgsToFormat,
    new InvalidRegex,
    new ImpossibleOptionSizeCondition,
    new IsInstanceOf,
    new JavaConversionsUse,
    new ListAppend,
    new ListSize,
    new LooksLikeInterpolatedString,
    new LonelySealedTrait,
    new MaxParameters,
    new MethodReturningAny,
    new ModOne,
    new NanComparison,
    new NegationIsEmpty,
    new NegationNonEmpty,
    new NullUse,
    new ObjectNames,
    new OptionGet,
    new OptionSize,
    new ParameterlessMethodReturnsUnit,
    new PartialFunctionInsteadOfMatch,
    new PointlessTypeBounds,
    new PreferSeqEmpty,
    new PreferSetEmpty,
    new PreferVectorEmpty,
    new ProductWithSerializableInferred,
    new RedundantFinalizer,
    new RepeatedCaseBody,
    new SimplifyBooleanExpression,
    new SubstringZero,
    new SuspiciousMatchOnClassObject,
    new SwapSortFilter,
    new TraversableHead,
    new TryGet,
    new TypeShadowing,
    new UnnecessaryIf,
    new UnnecessaryOverride,
    new UnnecessaryReturnUse,
    new UnnecessaryToInt,
    new UnnecessaryToString,
    new UnreachableCatch,
    new UnsafeContains,
    new UnusedMethodParameter,
    new UseSqrt,
    new VarClosure,
    new VarCouldBeVal,
    new VarUse,
    new WhileTrue,
    new ZeroNumerator)
}
